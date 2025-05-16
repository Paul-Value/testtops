package com.example.testtops.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "classes")
@Getter
@Setter
public class Classes {
    @Id
    @Column(name = "pk")
    private Long pk;

    @Column(name = "guid")
    private UUID guid;

    @Column(name = "groupid")
    private Long groupId;

    @Column(name = "baseclassid")
    private Long baseClassId;

    @Column(name = "name")
    private String name;

    @Column(name = "comment")
    private String comment;

    @Column(name = "icon")
    private byte[] icon;

    @Column(name = "sealed")
    private Boolean sealed;

    @Column(name = "abstract")
    private Boolean abstractClass;

    @Column(name = "usebaseclassicon")
    private Boolean useBaseClassIcon;

    @Column(name = "root")
    private Boolean root;

    @Column(name = "systemtype")
    private Integer systemType;

    @Column(name = "propertiesdisplaytype")
    private Integer propertiesDisplayType;

    @Column(name = "createfromprototype")
    private Boolean createFromPrototype;

    @Column(name = "supportssaveandcreate")
    private Boolean supportsSaveAndCreate;

    @Column(name = "uniqueindexid")
    private Long uniqueIndexId;

    @Column(name = "schemeid")
    private Long schemeId;

    @Column(name = "defaultstageid")
    private Long defaultStageId;

    @Column(name = "linkedclassid")
    private Long linkedClassId;

    @Column(name = "linkedinheritclasses")
    private String linkedInheritClasses;

    @Column(name = "attributes")
    private String attributes;

    @Column(name = "canchange")
    private Boolean canChange;

    @Column(name = "inheritmasterclasses")
    private Boolean inheritMasterClasses;

    @Column(name = "hidden")
    private Boolean hidden;

    @Column(name = "objectformat")
    private String objectFormat;

    @Column(name = "supportmultiattachment")
    private Boolean supportMultiAttachment;
}
