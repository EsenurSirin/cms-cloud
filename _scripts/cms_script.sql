create table cms.category
(
    id          varchar(255)              not null
        constraint pk_category
            primary key,
    name        varchar(255)              not null,
    description varchar(255)              not null,
    created_at  date default CURRENT_DATE not null,
    modified_at date default CURRENT_DATE
);

alter table cms.category
    owner to postgres;

create unique index category_id_uindex
    on cms.category (id);

create table cms.tag
(
    id          varchar(255) not null
        constraint tag_pk
            primary key,
    name        varchar(255) not null,
    created_at  date         not null,
    modified_at date
);

alter table cms.tag
    owner to postgres;

create unique index tag_id_uindex
    on cms.tag (id);

create table cms.users
(
    id            varchar(255) not null
        constraint user_pk
            primary key,
    email         varchar(255) not null,
    first_name    varchar(255) not null,
    last_name     varchar(255) not null,
    password      varchar(255) not null,
    user_name     varchar(255) not null,
    date_of_birth date         not null,
    telephone     varchar(255),
    created_at    date         not null,
    modified_at   date
);

alter table cms.users
    owner to postgres;

create unique index user_id_uindex
    on cms.users (id);

create table cms.article
(
    id          varchar(255) not null
        constraint article_pk
            primary key,
    category_id varchar(255) not null
        constraint article_category_id_fk
            references cms.category,
    content     varchar(255) not null,
    created_at  date         not null,
    modified_at date,
    title       varchar(255) not null,
    user_id     varchar(255)
        constraint article_users_id_fk
            references cms.users
);

alter table cms.article
    owner to postgres;

create table cms.article_tag
(
    id          varchar(255) not null
        constraint article_tag_pk
            primary key,
    article_id  varchar(255) not null
        constraint article_tag_article_id_fk
            references cms.article,
    tag_id      varchar(255) not null
        constraint article_tag_tag_id_fk
            references cms.tag,
    created_at  date         not null,
    modified_at date
);

alter table cms.article_tag
    owner to postgres;

create unique index article_tag_id_uindex
    on cms.article_tag (id);

create table cms.comment
(
    id          varchar(255) not null
        constraint comment_pk
            primary key,
    article_id  varchar(255) not null
        constraint comment_article_id_fk
            references cms.article,
    content     varchar(255) not null,
    created_at  date         not null,
    modified_at date,
    user_id     varchar(255) not null
        constraint comment_users_id_fk
            references cms.users
);

alter table cms.comment
    owner to postgres;

create unique index comment_id_uindex
    on cms.comment (id);

create table cms.liked
(
    article_id varchar(255) not null
        constraint liked_article_id_fk
            references cms.article,
    user_id    varchar(255) not null
        constraint liked_users_id_fk
            references cms.users,
    created_at date         not null
);

alter table cms.liked
    owner to postgres;

create table cms.log
(
    id         varchar(255) not null
        constraint log_pk
            primary key,
    user_name  varchar(255),
    operation  varchar(255),
    time       varchar(255),
    method     varchar(255),
    params     varchar(255),
    ip         varchar(255),
    created_at date,
    log_type   varchar(255)
);

alter table cms.log
    owner to postgres;

create unique index log_id_uindex
    on cms.log (id);


