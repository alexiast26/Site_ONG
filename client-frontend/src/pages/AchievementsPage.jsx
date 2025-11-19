import React from 'react';
import { useTranslation } from 'react-i18next';
import { motion } from 'framer-motion';
import './AchievementsPage.css';

const AchievementsPage = () => {
  const { t } = useTranslation();

  const floatingAnimation = {
    y: [-10, 10, -10],
    transition: {
      duration: 3,
      repeat: Infinity,
      ease: 'easeInOut'
    }
  };

  const pulseAnimation = {
    scale: [1, 1.05, 1],
    transition: {
      duration: 2,
      repeat: Infinity,
      ease: 'easeInOut'
    }
  };

  const dotAnimation = {
    opacity: [0, 1, 0],
    transition: {
      duration: 1.5,
      repeat: Infinity,
      ease: 'easeInOut'
    }
  };

  return (
    <div className="achievements-page">
      <motion.section
        className="achievements-hero"
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        transition={{ duration: 1 }}
      >
        <div className="achievements-background">
          <div className="floating-shapes">
            <motion.div
              className="shape shape-1"
              animate={floatingAnimation}
              transition={{ delay: 0 }}
            ></motion.div>
            <motion.div
              className="shape shape-2"
              animate={floatingAnimation}
              transition={{ delay: 0.5 }}
            ></motion.div>
            <motion.div
              className="shape shape-3"
              animate={floatingAnimation}
              transition={{ delay: 1 }}
            ></motion.div>
          </div>
        </div>

        <div className="achievements-content container">
          <motion.div
            className="trophy-icon"
            animate={pulseAnimation}
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="120"
              height="120"
              viewBox="0 0 24 24"
              fill="none"
              stroke="currentColor"
              strokeWidth="2"
              strokeLinecap="round"
              strokeLinejoin="round"
            >
              <path d="M6 9H4.5a2.5 2.5 0 0 1 0-5H6"></path>
              <path d="M18 9h1.5a2.5 2.5 0 0 0 0-5H18"></path>
              <path d="M4 22h16"></path>
              <path d="M10 14.66V17c0 .55-.47.98-.97 1.21C7.85 18.75 7 20.24 7 22"></path>
              <path d="M14 14.66V17c0 .55.47.98.97 1.21C16.15 18.75 17 20.24 17 22"></path>
              <path d="M18 2H6v7a6 6 0 0 0 12 0V2Z"></path>
            </svg>
          </motion.div>

          <motion.h1
            className="achievements-title"
            initial={{ opacity: 0, y: 30 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.8, delay: 0.2 }}
          >
            {t('achievements.title')}
          </motion.h1>

          <motion.div
            className="coming-soon-wrapper"
            initial={{ opacity: 0, y: 30 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.8, delay: 0.4 }}
          >
            <h2 className="coming-soon-text">
              {t('achievements.comingSoon')}
              <motion.span
                className="dot"
                animate={dotAnimation}
                transition={{ delay: 0 }}
              >
                .
              </motion.span>
              <motion.span
                className="dot"
                animate={dotAnimation}
                transition={{ delay: 0.3 }}
              >
                .
              </motion.span>
              <motion.span
                className="dot"
                animate={dotAnimation}
                transition={{ delay: 0.6 }}
              >
                .
              </motion.span>
            </h2>
          </motion.div>

          <motion.p
            className="achievements-description"
            initial={{ opacity: 0, y: 30 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.8, delay: 0.6 }}
          >
            {t('achievements.description')}
          </motion.p>

          <motion.div
            className="progress-bar-container"
            initial={{ opacity: 0, scale: 0.8 }}
            animate={{ opacity: 1, scale: 1 }}
            transition={{ duration: 0.8, delay: 0.8 }}
          >
            <div className="progress-bar">
              <motion.div
                className="progress-fill"
                initial={{ width: '0%' }}
                animate={{ width: '75%' }}
                transition={{ duration: 2, delay: 1, ease: 'easeOut' }}
              ></motion.div>
            </div>
            <p className="progress-text">Working on something amazing...</p>
          </motion.div>

          <motion.div
            className="achievements-icons"
            initial={{ opacity: 0 }}
            animate={{ opacity: 1 }}
            transition={{ duration: 1, delay: 1.2 }}
          >
            <motion.div
              className="achievement-icon"
              whileHover={{ scale: 1.2, rotate: 10 }}
              transition={{ type: 'spring', stiffness: 300 }}
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="48"
                height="48"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                strokeWidth="2"
                strokeLinecap="round"
                strokeLinejoin="round"
              >
                <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2"></polygon>
              </svg>
            </motion.div>
            <motion.div
              className="achievement-icon"
              whileHover={{ scale: 1.2, rotate: -10 }}
              transition={{ type: 'spring', stiffness: 300 }}
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="48"
                height="48"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                strokeWidth="2"
                strokeLinecap="round"
                strokeLinejoin="round"
              >
                <path d="M22 11.08V12a10 10 0 1 1-5.93-9.14"></path>
                <polyline points="22 4 12 14.01 9 11.01"></polyline>
              </svg>
            </motion.div>
            <motion.div
              className="achievement-icon"
              whileHover={{ scale: 1.2, rotate: 10 }}
              transition={{ type: 'spring', stiffness: 300 }}
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="48"
                height="48"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                strokeWidth="2"
                strokeLinecap="round"
                strokeLinejoin="round"
              >
                <path d="M20.42 4.58a5.4 5.4 0 0 0-7.65 0l-.77.78-.77-.78a5.4 5.4 0 0 0-7.65 0C1.46 6.7 1.33 10.28 4 13l8 8 8-8c2.67-2.72 2.54-6.3.42-8.42z"></path>
              </svg>
            </motion.div>
          </motion.div>
        </div>
      </motion.section>
    </div>
  );
};

export default AchievementsPage;
