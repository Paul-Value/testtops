package com.example.testtops.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "plm")
@Getter
@Setter
public class Plm {
    @Id
    @Column(name = "s_pk")
    private Long sPk;

    @Column(name = "s_objectid")
    private Long objectId;

    @Column(name = "s_guid")
    private UUID guid;

    @Column(name = "s_version")
    private Integer version;

    @Column(name = "s_actualversion")
    private Integer actualVersion;

    @Column(name = "s_clientviewid")
    private Integer clientViewId;

    @Column(name = "s_deleted")
    private Boolean deleted;

    @Column(name = "s_state")
    private Integer state;

    @Column(name = "s_authorid")
    private Long authorId;

    @Column(name = "s_creationdate")
    private LocalDateTime creationDate;

    @Column(name = "s_editorid")
    private Long editorId;

    @Column(name = "s_editdate")
    private LocalDateTime editDate;

    @Column(name = "s_classid")
    private Long classId;

    @Column(name = "s_accessobjectid")
    private Long accessObjectId;

    @Column(name = "s_sourceversion")
    private Integer sourceVersion;

    @Column(name = "s_stageid")
    private Integer stageId;

    @Column(name = "s_linkedobjectid")
    private Long linkedObjectId;

    @Column(name = "s_linkedobjectclassid")
    private Long linkedObjectClassId;

    @Column(name = "s_accesslevel")
    private Integer accessLevel;

    @Column(name = "s_ownerid")
    private Long ownerId;

    @Column(name = "s_logicalobjectguid")
    private UUID logicalObjectGuid;

    @Column(name = "s_revisionname")
    private String revisionName;

    @Column(name = "s_actualrevision")
    private Integer actualRevision;

    @Column(name = "oboznachenie_421975")
    private String oboznachenie;

    @Column(name = "name")
    private String name;
}
