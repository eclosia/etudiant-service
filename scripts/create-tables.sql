-- nom de la base de donnee  etudiant_db
-- Table des competences
CREATE TABLE IF NOT EXISTS competences (
    id BIGSERIAL PRIMARY KEY,
    etudiant_id BIGINT NOT NULL,
    nom VARCHAR(255) NOT NULL,
    niveau INTEGER NOT NULL CHECK (niveau >= 0 AND niveau <= 100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

-- Table des parcours academiques
CREATE TABLE IF NOT EXISTS parcours_academiques (
    id BIGSERIAL PRIMARY KEY,
    etudiant_id BIGINT NOT NULL,
    diplome VARCHAR(255) NOT NULL,
    periode VARCHAR(255) NOT NULL,
    etablissement VARCHAR(255) NOT NULL,
    lieu VARCHAR(255) NOT NULL,
    statut VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

-- Table des experiences professionnelles
CREATE TABLE IF NOT EXISTS experiences_professionnelles (
    id BIGSERIAL PRIMARY KEY,
    etudiant_id BIGINT NOT NULL,
    titre VARCHAR(255) NOT NULL,
    entreprise VARCHAR(255) NOT NULL,
    periode VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

-- Index pour amliorer les performances
CREATE INDEX IF NOT EXISTS idx_competences_etudiant_id ON competences(etudiant_id);
CREATE INDEX IF NOT EXISTS idx_parcours_academiques_etudiant_id ON parcours_academiques(etudiant_id);
CREATE INDEX IF NOT EXISTS idx_experiences_professionnelles_etudiant_id ON experiences_professionnelles(etudiant_id);

-- Contrainte pour le statut du parcours académique
ALTER TABLE parcours_academiques
    ADD CONSTRAINT chk_statut CHECK (statut IS NULL OR statut = 'actuel');
