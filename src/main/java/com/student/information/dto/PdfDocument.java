package com.student.information.dto;

import lombok.Data;

@Data
public class PdfDocument {
    
    private String filename;
    private byte[] content;

}
