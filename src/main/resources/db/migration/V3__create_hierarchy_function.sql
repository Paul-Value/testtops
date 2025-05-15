CREATE OR REPLACE FUNCTION get_plm_hierarchy()
RETURNS JSON AS $$
WITH RECURSIVE hierarchy AS (
    SELECT
        p.s_objectid AS object_id,
        p.name,
        p.oboznachenie_421975 AS oboznachenie,
        c.name AS class_name,
        ph.s_parentid AS parent_id,
        ARRAY[p.s_objectid] AS path
    FROM plm p
    LEFT JOIN classes c ON p.s_classid = c.pk
    LEFT JOIN plmhierarchy ph ON p.s_objectid = ph.s_objectid
    WHERE ph.s_parentid IS NULL

    UNION ALL

    SELECT
        p.s_objectid,
        p.name,
        p.oboznachenie_421975,
        c.name,
        ph.s_parentid,
        h.path || p.s_objectid
    FROM plm p
    LEFT JOIN classes c ON p.s_classid = c.pk
    LEFT JOIN plmhierarchy ph ON p.s_objectid = ph.s_objectid
    JOIN hierarchy h ON ph.s_parentid = h.object_id
    WHERE NOT p.s_objectid = ANY(h.path)
)

SELECT json_agg(
    json_build_object(
        'objectId', object_id,
        'name', name,
        'oboznachenie', oboznachenie,
        'className', class_name,
        'children', (
            SELECT
                CASE
                    WHEN COUNT(child) > 0 THEN json_agg(child)
                    ELSE NULL
                END
            FROM (
                SELECT
                    json_build_object(
                        'objectId', child.object_id,
                        'name', child.name,
                        'oboznachenie', child.oboznachenie,
                        'className', child.class_name,
                        'children', (
                            SELECT
                                CASE
                                    WHEN COUNT(subchild) > 0 THEN json_agg(subchild)
                                    ELSE NULL
                                END
                            FROM (
                                SELECT
                                    json_build_object(
                                        'objectId', sub.object_id,
                                        'name', sub.name,
                                        'oboznachenie', sub.oboznachenie,
                                        'className', sub.class_name
                                    ) AS subchild
                                FROM hierarchy sub
                                WHERE sub.parent_id = child.object_id
                            ) AS subchildren
                        )
                    ) AS child
                FROM hierarchy child
                WHERE child.parent_id = parent.object_id
            ) AS children
        )
    )
)
FROM hierarchy parent
WHERE parent.parent_id IS NULL;
$$ LANGUAGE SQL;