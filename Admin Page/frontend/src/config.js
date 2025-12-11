// API Configuration
// In development (npm start): uses localhost:8081 (Admin Panel Backend)
// In production (Docker): uses /api which is proxied by nginx to the backend
export const API_BASE_URL = process.env.NODE_ENV === 'production'
  ? '/api'
  : 'http://localhost:8081/api';
