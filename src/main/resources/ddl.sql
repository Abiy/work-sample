

    DROP TABLE IF EXISTS auction;
    CREATE TABLE auction (
       auction_id bigint not null,
        end_time timestamp,
        product_id varchar(255),
        start_time timestamp,
        version bigint,
        winner_price double,
        floor_price double,
        primary key (auction_id),
        foreign key (product_id) references product(product_id)
    )

    DROP TABLE IF EXISTS auction_bid;
    CREATE TABLE auction_bid (
       auction_bid_id bigint not null,
        auction_id bigint,
        bid_price double,
        bid_time timestamp,
        user_id varchar(255),
        primary key (auction_bid_id),
        foreign key (auction_id) references auction(auction_id)
    )

    DROP TABLE IF EXISTS product;
    CREATE TABLE product (
       product_id bigint not null,
        created_by varchar(255),
        created_on timestamp,
        product_description varchar(255),
        product_image varchar(255),
        product_name varchar(255),
        updated_by varchar(255),
        updated_on timestamp,
        primary key (product_id)
    )