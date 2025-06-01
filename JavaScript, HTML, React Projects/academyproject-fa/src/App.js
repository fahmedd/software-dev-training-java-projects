import './App.css';
import { Route,Routes } from 'react-router-dom'
import Home from './components/Home';
import Navbar from './components/Navbar';
import Academies from './components/Academies';
import Trainees from './components/Trainees';
import Trainers from './components/Trainers';
import Footer from './components/Footer';
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle";
import AddAcadmey from './components/AddAcademy';
import ExamResultsPage from './components/ExamResultsPage';

function App() {
  return (
    <div className="App">
        <Navbar/>
      <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/Home" element={<Home/>}/>
          <Route path="/Academies" element={<Academies/>}/>
          <Route path="/Trainees" element={<Trainees/>}/> 
          <Route path="/Trainers" element={<Trainers/>}/>
          <Route path='/AddAcademy' element={<AddAcadmey/>}/>
          <Route path='/ExamResultsPage/:id' element={<ExamResultsPage/>}/>
      </Routes>
      <Footer/>
    </div>
  );
}

export default App;
