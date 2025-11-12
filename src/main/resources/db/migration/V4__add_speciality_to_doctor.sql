ALTER TABLE doctor
ADD CONSTRAINT chk_speciality CHECK(
    specialty IN (
        'CARDIOLOGISTA',
        'NEUROLOGISTA',
        'ORTOPEDISTA',
        'PEDIATRA',
        'DERMATOLOGIA',
        'GINECOLOGIA',
        'CLINICA_GERAL'
    )
);