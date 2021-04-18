CREATE TABLE Users (
    id SERIAL,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    pass TEXT UNIQUE NOT NULL,
    position TEXT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE TimeSheets (
    time_id SERIAL,
    id INTEGER NOT NULL,
    submit_date DATE NOT NULL,
    total_hrs NUMERIC (2, 2),
    status TEXT NOT NULL,
    PRIMARY KEY (time_id),
    FOREIGN KEY (id) REFERENCES Users (id)
);