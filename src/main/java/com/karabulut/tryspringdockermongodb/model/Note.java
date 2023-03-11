package com.karabulut.tryspringdockermongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    @NonNull
    private int id;
    private LocalDateTime creationDate;
    @NonNull
    private String mailAddress;
    private String phoneNumber;
    @NonNull
    private String note;
}
