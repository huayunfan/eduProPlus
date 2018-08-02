package com.neu.check;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neu.check.CheckSumBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * ?????
 * @author liuxuanlin
 *
 */
public class MobileCheck {
    //??????????URL
    private static final String
            SERVER_URL="https://api.netease.im/sms/sendcode.action";
    //?????????????????????????Appkey
    private static final String
            APP_KEY="18be889fdf1ba20e7b6b1cba9289387d";
    //?????????????????????????appSecret
    private static final String APP_SECRET="9096ffc9c216";
    //???
    private static final String NONCE="123456";
    //????ID
    private static final String TEMPLATEID="4003265";
    //???
    private static final String MOBILE="13888888888";
    //????????4?10????4
    private static final String CODELEN="6";

    public static void main(String[] args) throws Exception {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(SERVER_URL);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        /*
         * ????CheckSum?java????????????????CheckSum???????
         */
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);

        // ?????header
        httpPost.addHeader("AppKey", APP_KEY);
        httpPost.addHeader("Nonce", NONCE);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // ?????????requestBody??
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        /*
         * 1.?????????????mobile??s?????????????????????
         * 2.?????jsonArray?????? "['13888888888','13666666666']"
         * 3.params??????????????????????jsonArray??
         */
        nvps.add(new BasicNameValuePair("templateid", TEMPLATEID));
        nvps.add(new BasicNameValuePair("mobile", MOBILE));
        nvps.add(new BasicNameValuePair("codeLen", CODELEN));

        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // ????
        HttpResponse response = httpClient.execute(httpPost);
        /*
         * 1.??????????????200?315?403?404?413?414?500
         * 2.???code???????????Code???
         */
        System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));

    }
}
