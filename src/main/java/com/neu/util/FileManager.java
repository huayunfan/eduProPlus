package com.neu.util;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.File;


public class FileManager implements FileManagerConfig {
    private static final long serialVersionUID = 1L;
    private static TrackerClient trackerClient;
    private static TrackerServer trackerServer;
    private static StorageServer storageServer;
    private static StorageClient storageClient;

    static {
        try {
            String classPath = new File(FileManager.class.getResource("/").getFile()).getCanonicalPath();
            System.out.println(classPath);
            String fdfsClientConfigFilePath = classPath + File.separator + CLIENT_CONFIG_FILE;
            ClientGlobal.init(fdfsClientConfigFilePath);
            System.out.println(fdfsClientConfigFilePath);
            trackerClient = new TrackerClient();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * <strong>方法概要： 文件上传</strong> <br> * <strong>创建时间： 2016-9-26 上午10:26:11</strong> <br> * * @param FastDFSFile * file * @return fileAbsolutePath * @author Wang Liang
     */
    public static String upload(FastDFSFile file, NameValuePair[] valuePairs) {
        String[] uploadResults = null;
        try {
            TrackerServer trackerServer = trackerClient.getConnection();
            System.out.println(trackerServer);

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            System.out.println(storageClient);
            uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), valuePairs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String groupName = uploadResults[0];
        String remoteFileName = uploadResults[1];
        String fileAbsolutePath = PROTOCOL + TRACKER_NGNIX_ADDR //+ trackerServer.getInetSocketAddress().getHostName()
                +":"+ TRACKER_NGNIX_PORT
                + SEPARATOR + groupName + SEPARATOR + remoteFileName;
        return fileAbsolutePath;
    }
}

