CREATE TABLE Users(
    UserID INT UNIQUE AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(20),
    Email VARCHAR(100),
    ModStatus BOOLEAN DEFAULT NULL,
    UserSecretCode VARCHAR(255),
    ProfilePic VARCHAR(255)
);

CREATE TABLE Article(
    ArticleID INT UNIQUE AUTO_INCREMENT PRIMARY KEY,
    UploadDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Sender INT,
    FOREIGN KEY (Sender) REFERENCES Users(UserID),
    Title VARCHAR(60),
    Article VARCHAR(255),
    NSFW BOOLEAN DEFAULT NULL 
);

CREATE TABLE Tags(
    TagID INT UNIQUE AUTO_INCREMENT PRIMARY KEY,
    Tag VARCHAR(50)
);

CREATE TABLE Comments(
    Comment VARCHAR(160),
    Commenter INT,
    Article INT,
    FOREIGN KEY (Commenter) REFERENCES Users(UserID),
    FOREIGN KEY (Article) REFERENCES Article(ArticleID),
    CommentDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Votes(
    Voter INT,
    Article INT,
    VoteType BOOLEAN,
    FOREIGN KEY (Voter) REFERENCES User(UserID),
    FOREIGN KEY (Article) REFERENCES Article(ArticleID),
    PRIMARY KEY (Voter, Article)
);

CREATE TABLE TagMap(
    Article INT,
    Tag INT,
    FOREIGN KEY (Article) REFERENCES Article(ArticleID),
    FOREIGN KEY (Tag) REFERENCES Tag(TagID),
);

CREATE TABLE Favorites(
    User INT,
    Article INT,
    FOREIGN KEY (User) REFERENCES User(UserID),
    FOREIGN KEY (Article) REFERENCES Article(ArticleID),
    PRIMARY KEY (User, Article)
);

CREATE TABLE Follows(
    User INT,
    Followed INT,
    FOREIGN KEY (User) REFERENCES User(UserID),
    FOREIGN KEY (User) REFERENCES User(UserID),
    PRIMARY KEY (User, Followed)
);

INSERT INTO Users(
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

INSERT INTO Article(
    Sender,
    Title,
    Article,
    NSFW
)
VALUES(
    '3',
    'HAUSKA KOIRAKUVA',
    'www.kuva.orgy',
    '0'
);