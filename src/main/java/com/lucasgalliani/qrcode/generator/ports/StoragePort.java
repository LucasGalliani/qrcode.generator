package com.lucasgalliani.qrcode.generator.ports;

public interface StoragePort {

    String uploadFile(byte[] filedata,String filename,String contentType);
}
