ALTER TABLE parties
ADD COLUMN guests_id int REFERENCES guests(id);