BEGIN;
ALTER TABLE medical_records
DROP COLUMN IF EXISTS allergies;

CREATE TABLE allergies (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    medical_record_id UUID NOT NULL,
    FOREIGN KEY (medical_record_id) REFERENCES medical_records(id)
);

COMMIT;