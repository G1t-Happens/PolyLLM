-- V1__init_postgresql.sql
-- Create conversations and conversation_messages tables
-- with automatic update of the "updated" timestamp column on row modifications.

-- Create the conversations table
CREATE TABLE conversations
(
    id           UUID PRIMARY KEY,
    llm_provider VARCHAR(100) NOT NULL,
    created      TIMESTAMPTZ  NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Timestamp of creation, set once
    updated      TIMESTAMPTZ  NOT NULL DEFAULT CURRENT_TIMESTAMP  -- Timestamp of last update, updated by trigger
);

-- Create the conversation_messages table
CREATE TABLE conversation_messages
(
    id              UUID PRIMARY KEY,
    conversation_id UUID        NOT NULL REFERENCES conversations (id) ON DELETE CASCADE, -- Foreign key with cascade delete
    role            VARCHAR(50) NOT NULL,
    content         TEXT        NOT NULL,
    created         TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,                       -- Timestamp of creation
    updated         TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP                        -- Timestamp of last update
);

-- Trigger function to update the "updated" timestamp column on row update
CREATE
OR REPLACE FUNCTION update_updated_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated
= CURRENT_TIMESTAMP;  -- Set updated to current timestamp before updating the row
RETURN NEW;
END;
$$
LANGUAGE plpgsql;

-- Trigger to invoke the update_updated_column function before updating conversations table
CREATE TRIGGER trg_update_conversations_updated
    BEFORE UPDATE
    ON conversations
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_column();

-- Trigger to invoke the update_updated_column function before updating conversation_messages table
CREATE TRIGGER trg_update_conversation_messages_updated
    BEFORE UPDATE
    ON conversation_messages
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_column();
