db = db.getSiblingDB('market');
db.createCollection('market');
db.createUser(
    {
        user: "root",
        pwd: "root",
        roles: [
            {
                role: "readWrite",
                db: "market"
            }
        ]
    }
);
db = db.getSiblingDB('market_test');
db.createCollection('market_test');
db.createUser(
    {
        user: "root",
        pwd: "root",
        roles: [
            {
                role: "readWrite",
                db: "market_test"
            }
        ]
    }
);