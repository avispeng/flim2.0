CREATE DATABASE IF NOT EXISTS flim;
USE flim;

CREATE TABLE IF NOT EXISTS users
(
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(20) NOT NULL,
  `hashed_pwd` char(64) NOT NULL,
  `salt` char(8) NOT NULL,
  `email` varchar(254) DEFAULT NULL,
  `location` char(30) DEFAULT NULL,
  `user_profile` json DEFAULT NULL,
  PRIMARY KEY (`userid`)
);

CREATE TABLE IF NOT EXISTS reviews
(
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `review_title` varchar(130) DEFAULT NULL,
  `review` text NOT NULL,
  `thumb_up` int(11) NOT NULL,
  `time_stamp` datetime NOT NULL,
  `rating` float DEFAULT NULL,
  PRIMARY KEY (`review_id`)
);

CREATE TABLE IF NOT EXISTS movies 
(
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `imdb_id` char(9) NOT NULL,
  `movie_title` varchar(250) NOT NULL,
  `rating` float DEFAULT NULL,
  `movie_profile` json DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `genres` json DEFAULT NULL,
  `poster` varchar(512) DEFAULT NULL,
  `summary` text,
  `rating_capita` int(11) DEFAULT NULL,
  `rating_sum` float DEFAULT NULL,
  PRIMARY KEY (`movie_id`)
);

CREATE TABLE IF NOT EXISTS comments
(
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `review_id` int(11) NOT NULL,
  `floor` int(11) NOT NULL,
  `reply_to` int(11) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  `content` text NOT NULL,
  `thumb_up` int(11) NOT NULL,
  `time_stamp` datetime NOT NULL,
  PRIMARY KEY (`comment_id`)
);