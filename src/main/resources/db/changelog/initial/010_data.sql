insert into AUTHORITIES(AUTHORITY) values ( 'USER' );

insert into USERS(username, personal_account_number, AMOUNT_MONEY, password, enabled, account_type)
VALUES ( 'argen', 111111, 1000.0, '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', true, 1), // qwe
       ('kanat', 222222, 2000.0, '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', true, 1), // qwe
    ('Sergey', 333333, 30000.0, '$2a$12$1KBqXbpe.nOUNBTUJ1aduO3RtC4KBQq1i8riuzA8rhTtfNHxtrwI.', true, 1), // sergey
    ('CoolBoy', 444444, 1000.0, '$2a$12$gz.Gav5QFoohlrA5Ld.pROdA/zazdfkifXuqlaemMLzTxxBunCNs6', true, 1); // C01lb0y


insert into TRANSACTIONS(from_account_id, to_account_id, amount, transaction_time)
VALUES ( 111111,  222222, 500.0, current_timestamp()),
       ( 222222, 111111, 1000.0, current_timestamp());

insert into TRANSACTIONS(from_account_id, to_account_id, amount, transaction_time)
VALUES
    (333333, 444444, 1500.0, current_timestamp()),
    (444444, 333333, 2500.0, current_timestamp()),
    (111111, 333333, 200.0, current_timestamp()),
    (222222, 444444, 300.0, current_timestamp());

insert into PROVIDERS(name, ACCOUNT, BALANCE)
VALUES ( 'Мобильная связь', 999999, 1000),
       ('Коммуналка', 888888, 1000),
       ('Интернет и ТВ', 090909, 1000),
       ('Штрафы и налоги', 010101, 1000),
       ('Отопление', 080808, 1000);

insert into PROVIDERS(name, ACCOUNT, BALANCE)
VALUES
    ('Горячая вода', 070707, 500),
    ('Электричество', 060606, 1500),
    ('Газоснабжение', 050505, 2000),
    ('Утилизация отходов', 040404, 800),
    ('Парковка', 030303, 1200);


insert into UNIQUE_NUMBERS(UNIQUE_NUMBER)
values ( 111111 ),
       ( 222222 ),
       ( 333333 ),
       ( 444444 ),
       ( 999999 ),
       ( 888888 ),
       ( 090909 ),
       ( 010101 ),
       ( 080808 ),
       ( 070707 ),
       ( 060606 ),
       ( 050505 ),
       ( 040404 ),
       ( 030303 );
