import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Layout/Navbar';
import Footer from './components/Layout/Footer';
import HomePage from './pages/HomePage';
import ArticlesPage from './pages/ArticlesPage';
import UpcomingProjectsPage from './pages/UpcomingProjectsPage';
import CompletedProjectsPage from './pages/CompletedProjectsPage';
import AchievementsPage from './pages/AchievementsPage';
import DonatePage from './pages/DonatePage';
import './styles/GlobalStyles.css';
import './i18n';

function App() {
  return (
    <Router>
      <div className="App">
        <Navbar />
        <main>
          <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/articles" element={<ArticlesPage />} />
            <Route path="/upcoming-projects" element={<UpcomingProjectsPage />} />
            <Route path="/completed-projects" element={<CompletedProjectsPage />} />
            <Route path="/achievements" element={<AchievementsPage />} />
            <Route path="/donate" element={<DonatePage />} />
          </Routes>
        </main>
        <Footer />
      </div>
    </Router>
  );
}

export default App;
