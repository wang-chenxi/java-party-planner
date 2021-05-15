ALTER TABLE guests
ADD COLUMN party_id int REFERENCES parties(id);

ALTER TABLE parties
DROP COLUMN guests_id;