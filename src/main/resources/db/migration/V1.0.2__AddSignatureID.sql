BEGIN;
ALTER TABLE psychologists
    ADD COLUMN signature_id UUID;
COMMIT;