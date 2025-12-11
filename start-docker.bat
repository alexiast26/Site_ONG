@echo off
echo ============================================
echo  ONG Website - Docker Startup Script
echo ============================================
echo.

REM Check if Docker is running
docker info >nul 2>&1
if errorlevel 1 (
    echo [ERROR] Docker is not running!
    echo.
    echo Please start Docker Desktop and wait for it to be ready.
    echo Then run this script again.
    echo.
    pause
    exit /b 1
)

echo [OK] Docker is running
echo.
echo Starting all services...
echo - Backend: http://localhost:8080
echo - Client Frontend: http://localhost:3000
echo - Admin Panel: http://localhost:3001
echo.
echo This may take a few minutes on first run...
echo.

docker-compose up --build

pause
