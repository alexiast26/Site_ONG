import React from 'react';
import { motion } from 'framer-motion';
import './KidsPeeking.css';

const KidsPeeking = () => {
  const peekAnimation = {
    hidden: { y: 100, opacity: 0 },
    visible: (custom) => ({
      y: 0,
      opacity: 1,
      transition: {
        delay: custom * 0.5,
        duration: 0.8,
        ease: 'easeOut'
      }
    }),
    peek: (custom) => ({
      y: [0, -20, -10, -15, 0],
      rotate: [0, -5, 5, -3, 0],
      transition: {
        delay: custom * 0.5 + 1,
        duration: 2,
        repeat: Infinity,
        repeatDelay: 3,
        ease: 'easeInOut'
      }
    })
  };

  const waveAnimation = {
    wave: {
      rotate: [0, 14, -8, 14, -4, 10, 0, 0],
      transition: {
        duration: 2,
        repeat: Infinity,
        repeatDelay: 3,
        ease: 'easeInOut'
      }
    }
  };

  return (
    <div className="kids-peeking-container">
      {/* Kid 1 - Bottom Left */}
      <motion.div
        className="peeking-kid kid-1"
        initial="hidden"
        animate={['visible', 'peek']}
        custom={0}
        variants={peekAnimation}
      >
        <div className="kid-character">
          <div className="kid-head">
            <div className="kid-hair hair-brown"></div>
            <div className="kid-face">
              <div className="kid-eyes">
                <div className="kid-eye left"></div>
                <div className="kid-eye right"></div>
              </div>
              <div className="kid-smile"></div>
            </div>
          </div>
          <motion.div
            className="kid-hand"
            animate="wave"
            variants={waveAnimation}
          >
            👋
          </motion.div>
        </div>
      </motion.div>

      {/* Kid 2 - Bottom Right */}
      <motion.div
        className="peeking-kid kid-2"
        initial="hidden"
        animate={['visible', 'peek']}
        custom={1}
        variants={peekAnimation}
      >
        <div className="kid-character">
          <div className="kid-head">
            <div className="kid-hair hair-blonde"></div>
            <div className="kid-face">
              <div className="kid-eyes">
                <div className="kid-eye left"></div>
                <div className="kid-eye right"></div>
              </div>
              <div className="kid-smile"></div>
            </div>
          </div>
          <div className="kid-hand-static">
            ✨
          </div>
        </div>
      </motion.div>

      {/* Kid 3 - Left Side */}
      <motion.div
        className="peeking-kid kid-3"
        initial="hidden"
        animate={['visible', 'peek']}
        custom={0.5}
        variants={peekAnimation}
      >
        <div className="kid-character">
          <div className="kid-head">
            <div className="kid-hair hair-black"></div>
            <div className="kid-face">
              <div className="kid-eyes">
                <div className="kid-eye left"></div>
                <div className="kid-eye right"></div>
              </div>
              <div className="kid-smile"></div>
            </div>
          </div>
        </div>
      </motion.div>
    </div>
  );
};

export default KidsPeeking;
