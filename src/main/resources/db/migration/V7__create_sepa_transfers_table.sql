-- V7__create_sepa_transfers_table.sql
-- Migration #7: create table sepa_transfers

-- Creating table 'sepa_transfers' for saving main data of sepa_transfers
CREATE TABLE sepa_transfers (
    id                  BIGSERIAL PRIMARY KEY,
    payment_id          BIGINT NOT NULL,           -- Foreign key на платеж
    debtor_iban         VARCHAR(34) NOT NULL,      -- IBAN отправителя
    creditor_iban       VARCHAR(34) NOT NULL,      -- IBAN получателя
    creditor_name       VARCHAR(255) NOT NULL,     -- Имя получателя
    remittance_info     TEXT,                      -- Назначение платежа
    instant             BOOLEAN DEFAULT FALSE      -- Мгновенный перевод или классический
);

-- Setting up foreign key constraint
CREATE INDEX idx_sepa_transfers_payment_id ON sepa_transfers(payment_id);
CREATE INDEX idx_sepa_transfers_debtor_iban ON sepa_transfers(debtor_iban);
CREATE INDEX idx_sepa_transfers_creditor_iban ON sepa_transfers(creditor_iban);
CREATE INDEX idx_sepa_transfers_instant ON sepa_transfers(instant);

