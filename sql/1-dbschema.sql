create table messages
(
    id          serial primary key,
    text        varchar(255) not null,
    insert_time timestamp    not null default now()
);