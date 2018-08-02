package com.neu.util;

import java.io.Serializable;

public interface FileManagerConfig extends Serializable {
    public static final String FILE_DEFAULT_AUTHOR = "EduPro";
    public static final String PROTOCOL = "http://";
    public static final String SEPARATOR = "/";
    public static final String TRACKER_NGNIX_ADDR = "123.206.32.30";
    public static final String TRACKER_NGNIX_PORT = "81";
    public static final String CLIENT_CONFIG_FILE = "client.conf";
}

