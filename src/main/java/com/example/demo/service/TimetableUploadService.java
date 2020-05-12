package com.example.demo.service;

import com.example.demo.models.nonEntity.TimetableUpload;

import java.util.List;

public interface TimetableUploadService {

    void saveDataFromCsvFile( List<TimetableUpload> inputData);

}
