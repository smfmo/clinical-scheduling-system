CREATE TABLE consultation (
    id uuid PRIMARY KEY,
    patient_id UUID NOT NULL,
    doctor_id UUID NOT NULL,
    consultation_date DATE NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    CONSTRAINT chk_status CHECK (status IN ('AGENDADA', 'CONFIRMADA', 'CANCELADA', 'REALIZADA', 'PENDENTE')),
    CONSTRAINT fk_patient FOREIGN KEY (patient_id) REFERENCES patient(id) ON DELETE CASCADE,
    CONSTRAINT fk_doctor FOREIGN KEY (doctor_id) REFERENCES doctor(id) ON DELETE CASCADE
);