-- V1__Create_initial_tables.sql

CREATE TABLE users
(
    id         UUID PRIMARY KEY,
    email      VARCHAR(255),
    password   VARCHAR(255),
    name       VARCHAR(255),
    phone      VARCHAR(50),
    role       VARCHAR(50),
    address    VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- Table: activity_histories
CREATE TABLE activity_histories
(
    id                UUID PRIMARY KEY,
    medical_record_id UUID,
    date              DATE,
    activity          VARCHAR(255),
    observations      TEXT
);

-- Table: appointments
CREATE TABLE appointments
(
    id              UUID PRIMARY KEY,
    patient_id      UUID,
    psychologist_id UUID,
    date            TIMESTAMP,
    time            VARCHAR(50),
    status          VARCHAR(50),
    type            VARCHAR(50),
    description     TEXT,
    notes           TEXT,
    created_at      TIMESTAMP,
    updated_at      TIMESTAMP,
    is_deleted      BOOLEAN
);

-- Table: conducts
CREATE TABLE conducts
(
    id                UUID PRIMARY KEY,
    medical_record_id UUID,
    date              DATE,
    description       TEXT
);

-- Table: evolutions
CREATE TABLE evolutions
(
    id                UUID PRIMARY KEY,
    medical_record_id UUID,
    date              DATE,
    description       TEXT
);

-- Table: medical_records
CREATE TABLE medical_records
(
    id                     UUID PRIMARY KEY,
    patient_id             UUID,
    creation_date          DATE,
    allergies              TEXT,
    cognitive_limitations  BOOLEAN,
    locomotion_limitations BOOLEAN,
    vision_limitations     BOOLEAN,
    hearing_limitations    BOOLEAN,
    other_limitations      TEXT,
    consultation_reason    TEXT,
    next_session_date      DATE,
    session_value          NUMERIC(10, 2),
    payment_method         VARCHAR(50)
);

-- Table: medications
CREATE TABLE medications
(
    id                UUID PRIMARY KEY,
    medical_record_id UUID,
    name              VARCHAR(255),
    dosage            VARCHAR(50),
    frequency         VARCHAR(50)
);

-- Table: patients
CREATE TABLE patients
(
    id                   UUID PRIMARY KEY,
    user_id              UUID,
    cpf                  VARCHAR(14),
    rg                   VARCHAR(12),
    birth_date           DATE,
    civil_state          VARCHAR(50),
    gender               VARCHAR(50),
    first_time_treatment BOOLEAN,
    children_quantity    INTEGER,
    treatment_start_date DATE
);

-- Table: psychologists
CREATE TABLE psychologists
(
    id           UUID PRIMARY KEY,
    user_id      UUID,
    crp_state    VARCHAR(50),
    crp_number   VARCHAR(50),
    crp_type     VARCHAR(50),
    crp_status   VARCHAR(50),
    crp_validity DATE,
    pix_type     VARCHAR(50),
    pix_value    VARCHAR(255)
);

-- Table: signatures
CREATE TABLE signatures
(
    id              UUID PRIMARY KEY,
    user_id         UUID,
    payment_id      VARCHAR(255),
    signature_type  VARCHAR(50),
    expiration_date DATE,
    status          VARCHAR(50),
    created_at      TIMESTAMP,
    updated_at      TIMESTAMP,
    is_canceled     BOOLEAN
);

-- Table: signature_payments
CREATE TABLE signature_payments
(
    id               UUID PRIMARY KEY,
    user_id          UUID,
    signature_id     UUID,
    asaas_payment_id VARCHAR(255),
    value            NUMERIC(10, 2),
    status           VARCHAR(50),
    is_canceled      BOOLEAN,
    created_at       DATE,
    canceled_at      DATE,
    payment_date     DATE,
    expiration_date  DATE,
    is_expired       BOOLEAN
);
