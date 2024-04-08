

CREATE TABLE IF NOT EXISTS books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(20),
    publication_date DATE,
    genre VARCHAR(100),
    description TEXT,
    file_path VARCHAR(255)
);