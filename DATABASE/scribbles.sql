CREATE TABLE User(
    UserID INT UNIQUE AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(20),
    Email VARCHAR(100),
    ModStatus BOOLEAN DEFAULT NULL,
    UserSecretCode VARCHAR(255)
);

CREATE TABLE Post(
    PostID INT UNIQUE AUTO_INCREMENT PRIMARY KEY,
    PostDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    Poster FOREIGN KEY (UserID,
    Title VARCHAR(60),
    NSFW BOOLEAN DEFAULT NULL,
    PostVotes INT
);

INSERT INTO User(
    Username,
    Email,
    ModStatus,
    UserSecretCode
)
VALUES(
    'orgyfin',
    'orgymail@giggel.com',
    '1',
    'imemuonaa'

);