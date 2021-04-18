CREATE TABLE Employees (
    eid SERIAL,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT,
    PRIMARY KEY (eid)
);

CREATE TABLE Managers (
    mid SERIAL,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT,
    PRIMARY KEY (mid)
);

CREATE TABLE Users (
    eid INTEGER,
    mid INTEGER,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    pass TEXT UNIQUE NOT NULL,
    position TEXT NOT NULL,
    FOREIGN KEY (eid) REFERENCES Employees (eid),
    FOREIGN KEY (mid) REFERENCES Managers (mid)
);

CREATE TABLE PTime (
    ptime_id SERIAL,
    eid INTEGER NOT NULL,
    submit_date DATE NOT NULL,
    total_hrs NUMERIC (2, 2),
    PRIMARY KEY (ptime_id),
    FOREIGN KEY (eid) REFERENCES Employees (eid)
);

CREATE TABLE ATime (
    atime_id SERIAL,
    eid INTEGER NOT NULL,
    mid INTEGER NOT NULL,
    approved_date DATE NOT NULL,
    total_hrs NUMERIC (2, 2),
    PRIMARY KEY (atime_id),
    FOREIGN KEY (eid) REFERENCES Employees (eid),
    FOREIGN KEY (mid) REFERENCES Managers (mid)
);

CREATE TABLE DTime (
    dtime_id SERIAL,
    eid INTEGER NOT NULL,
    mid INTEGER NOT NULL,
    decline_date DATE NOT NULL,
    total_hrs NUMERIC (2, 2),
    PRIMARY KEY (dtime_id),
    FOREIGN KEY (eid) REFERENCES Employees (eid),
    FOREIGN KEY (mid) REFERENCES Managers (mid)
);
