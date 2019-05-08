CREATE TABLE IF NOT EXISTS quiz.users (
  `user_id` varchar(10) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;

CREATE TABLE IF NOT EXISTS quiz.categories (
  `category` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;

CREATE TABLE IF NOT EXISTS quiz.quizzes (
  `quiz_id` varchar(10) NOT NULL,
  `category` varchar(20) NOT NULL,
  `type` varchar(10) NOT NULL,
  `overview` varchar(50) NOT NULL,
  PRIMARY KEY (`quiz_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;

CREATE TABLE IF NOT EXISTS quiz.quiz_contents (
  `quiz_id` varchar(10) NOT NULL,
  `content` varchar(300) NOT NULL,
  `selection1` varchar(200),
  `selection2` varchar(200),
  `selection3` varchar(200),
  `selection4` varchar(200),
  PRIMARY KEY (`quiz_id`),
  KEY `quiz_contents_id` (`quiz_id`),
  CONSTRAINT `fk_quiz_contents` FOREIGN KEY (`quiz_id`) REFERENCES `quizzes` (`quiz_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;

CREATE TABLE IF NOT EXISTS quiz.quiz_answers (
  `quiz_id` varchar(10) NOT NULL,
  `answer` varchar(100) NOT NULL,
  PRIMARY KEY (`quiz_id`),
  KEY `quiz_answers_id` (`quiz_id`),
  CONSTRAINT `fk_quiz_answers` FOREIGN KEY (`quiz_id`) REFERENCES `quizzes` (`quiz_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;

CREATE TABLE IF NOT EXISTS quiz.results (
  `quiz_id` varchar(10) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `is_correct` varchar(1),
  `start_date` datetime NOT NULL,
  `end_date` datetime,
  `elapsed_time` time,
  KEY `i_quiz` (`quiz_id`),
  KEY `i_user` (`user_id`),
  CONSTRAINT `fk_quiz` FOREIGN KEY (`quiz_id`) REFERENCES `quizzes` (`quiz_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;
