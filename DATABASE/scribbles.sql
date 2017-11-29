CREATE TABLE User(
    UserID INT UNIQUE AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(20),
    Email VARCHAR(100),
    ModStatus BOOLEAN DEFAULT NULL,
    UserSecretCode VARCHAR(255)
);

CREATE TABLE Post(
    PostID INT UNIQUE AUTO_INCREMENT PRIMARY KEY,
    PostDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Poster INT,
    FOREIGN KEY (Poster) REFERENCES User(UserID),
    Title VARCHAR(60),
    NSFW BOOLEAN DEFAULT NULL,
);

CREATE TABLE Tag(
    TagID INT UNIQUE AUTO_INCREMENT PRIMARY KEY,
    Tag VARCHAR(50)
);

CREATE TABLE Comment(
    Comment VARCHAR(160),
    Commenter INT,
    Post INT,
    FOREIGN KEY (Commenter) REFERENCES User(UserID),
    FOREIGN KEY (Post) REFERENCES Post(PostID),
    CommentDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE 

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