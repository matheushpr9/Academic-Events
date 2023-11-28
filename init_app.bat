@echo off
type dependencies\config.json > .vscode\settings.json

REM
if not exist sqlite3.exe (
    echo Baixando o SQLite...
    curl -O https://sqlite.org/2022/sqlite-tools-win32-x86-3360000.zip
    tar -xzf sqlite-tools-win32-x86-3360000.zip
    del sqlite-tools-win32-x86-3360000.zip
)

echo [database-sql] Criando tabelas...
sqlite3 src\database\academic_events.db < src\database\sql\create_tables.sql
echo [database-sql] Tabelas criadas com sucesso!

echo [database-sql] Inserindo valores nas tabelas...
sqlite3 src\database\academic_events.db < src\database\sql\insert_values.sql
echo [database-sql] Valores inseridos com sucesso!
