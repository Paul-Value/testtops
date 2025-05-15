package com.example.testtops.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "plmhierarchy")
@Getter
@Setter
public class PlmHierarchy {
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
    private Integer deleted;

    @Column(name = "s_state")
    private Integer state;

    @Column(name = "s_parentid")
    private Long parentId;

    @Column(name = "s_firstuse")
    private Integer firstUse;

    @Column(name = "s_hierarchylinkid")
    private Long hierarchyLinkId;
}