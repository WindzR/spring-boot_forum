insert into posts (id, name, description) values (1, 'Hibernate vs Spring Data', 'Обсудим достоинства и недостатки этих фреймворков для работы с БД');
insert into posts (id, name, description) values (2, 'Servlet API', 'Фичи и особенности при работе с Servlets и JSP');
insert into posts (id, name, description) values (3, 'Java vs Kotlin', 'Обсуждение плюсов и минусов этих ЯП в проектах и удобства работы с ними');

insert into authors (id, name) values (1, 'Dmitry B.');
insert into authors (id, name) values (2, 'Petr A.');
insert into authors (id, name) values (3, 'Troll_face');
insert into authors (id, name) values (4, 'KappaPride');

insert into comments (id, comment, author_id) values (1, 'Spring Data интересная, но имеет свои подводные камни. Для прода лучше простой Хибер, а Дату оставить для тестов и пет проектов!', 1);
insert into comments (id, comment, author_id) values (2, 'Да Спринг Дата во всем лучше Хибернейта, но нужно хорошо знать ее доку и написать 2-3 тестовых проектов, прежде чем идти с ней в прод.', 2);
insert into comments (id, comment, author_id) values (3, 'Что то говно, что это! Только ДжейДиБиСи - только хардкор!', 3);
insert into comments (id, comment, author_id) values (4, 'Погромисты обленились! Написать методы с чистым SQL уже не могут! С вашими хиберами скоро забудете, как база работает! А это основа - это знать надо!', 4);
insert into comments (id, comment, author_id) values (5, 'Простая, надежная технология. Работает быстрее Спринга, если грамотно проектировать проект.', 2);
insert into comments (id, comment, author_id) values (6, 'Надежность надежностью, но технология устарела n лет назад! Будешь с ней работать, рискуешь в один момент оказаться на обочине IT, без работы.', 1);
insert into comments (id, comment, author_id) values (7, 'Хорошая тема!Нужно же, чтоб кто то копался в коричневой субстанции легаси проектов!', 4);
insert into comments (id, comment, author_id) values (8, 'Котлин - это джава с костылями. Где серьезные проекты - там джава, котлин для смузихлебов!', 2);
insert into comments (id, comment, author_id) values (9, 'На чистой джаве ваки 500+ практически не встречаются, в отличие от вак джава/котлин', 4);
insert into comments (id, comment, author_id) values (10, 'На вкус и цвет, на чем больше нравиться, на том и пишем!', 3);

INSERT INTO post_comments(id, post_id, comment_id) VALUES (1 , 1 , 1);
INSERT INTO post_comments(id, post_id, comment_id) VALUES (2 , 1 , 2);
INSERT INTO post_comments(id, post_id, comment_id) VALUES (3 , 1 , 3);
INSERT INTO post_comments(id, post_id, comment_id) VALUES (4 , 1 , 4);
INSERT INTO post_comments(id, post_id, comment_id) VALUES (5 , 2 , 5);
INSERT INTO post_comments(id, post_id, comment_id) VALUES (6 , 2 , 6);
INSERT INTO post_comments(id, post_id, comment_id) VALUES (7 , 2 , 7);
INSERT INTO post_comments(id, post_id, comment_id) VALUES (8 , 3 , 8);
INSERT INTO post_comments(id, post_id, comment_id) VALUES (9 , 3 , 9);
INSERT INTO post_comments(id, post_id, comment_id) VALUES (10 , 3 , 10);