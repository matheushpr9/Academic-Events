cat dependencies/config.json > .vscode/settings.json

sudo apt install sqlite3

#sqlite3 academic_events.db
echo "[database-sql] Creating tables..."
SQL_COMMANDS=$(cat src/database/sql/create_tables.sql)
sqlite3 src/database/academic_events.db "$SQL_COMMANDS"
echo "[database-sql] Tables created successfully!"

echo "[database-sql] Inserting values into tables..."
SQL_COMMANDS=$(cat src/database/sql/insert_values.sql)
sqlite3 src/database/academic_events.db "$SQL_COMMANDS"
echo "[database-sql] Values successfully inserted!"