CREATE TABLE IF NOT EXISTS plm (
    s_PK BIGINT PRIMARY KEY,
    s_ObjectID BIGINT,
    s_Guid UUID,
    s_Version INTEGER,
    s_ActualVersion INTEGER,
    s_ClientViewID INTEGER,
    s_Deleted INTEGER,
    s_State INTEGER,
    s_AuthorID BIGINT,
    s_CreationDate TIMESTAMP,
    s_EditorID BIGINT,
    s_EditDate TIMESTAMP,
    s_ClassID BIGINT,
    s_AccessObjectID BIGINT,
    s_SourceVersion INTEGER,
    s_StageID INTEGER,
    s_LinkedObjectID BIGINT,
    s_LinkedObjectClassID BIGINT,
    s_AccessLevel INTEGER,
    s_OwnerID BIGINT,
    s_LogicalObjectGuid UUID,
    s_RevisionName VARCHAR(255),
    s_ActualRevision INTEGER,
    oboznachenie_421975 VARCHAR(255),
    Name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS plmhierarchy (
    s_PK BIGINT PRIMARY KEY,
    s_ObjectID BIGINT,
    s_Guid UUID,
    s_Version INTEGER,
    s_ActualVersion INTEGER,
    s_ClientViewID INTEGER,
    s_Deleted INTEGER,
    s_State INTEGER,
    s_ParentID BIGINT,
    s_FirstUse INTEGER,
    s_HierarchyLinkID BIGINT
);

CREATE TABLE IF NOT EXISTS classes (
    pk BIGINT PRIMARY KEY,
    guid UUID,
    groupid BIGINT,
    baseclassid BIGINT,
    name VARCHAR(255),
    comment VARCHAR(255),
    icon BYTEA,
    sealed BOOLEAN,
    "abstract" BOOLEAN,
    usebaseclassicon BOOLEAN,
    root BOOLEAN,
    systemtype INTEGER,
    propertiesdisplaytype INTEGER,
    createfromprototype BOOLEAN,
    supportssaveandcreate BOOLEAN,
    uniqueindexid BIGINT,
    schemeid BIGINT,
    defaultstageid BIGINT,
    linkedclassid BIGINT,
    linkedinheritclasses VARCHAR(255),
    attributes VARCHAR(255),
    canchange BOOLEAN,
    inheritmasterclasses BOOLEAN,
    hidden BOOLEAN,
    objectformat VARCHAR(255),
    supportmultiattachment BOOLEAN
);