COPY plm FROM '/csv/plm.csv' DELIMITER ',' CSV HEADER;

COPY plmhierarchy FROM '/csv/plmHierarchy.csv' DELIMITER ',' CSV HEADER;

COPY classes FROM '/csv/Classes.csv' DELIMITER ',' CSV HEADER;