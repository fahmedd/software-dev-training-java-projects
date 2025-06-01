import '../styles/Navbar.css'
import {Link} from 'react-router-dom'


const Navbar = () => {
    return(
        <div className="topnav">
            <nav class="navbar navbar-expand-lg navbar-light bg-dark navbar-static-top">
                <div className="container">
                <h1 className='CompanyName'>FDM</h1>
                <Link to='/Home'>Home</Link>
                <Link to='/Academies'>Academies</Link>
                <Link to='/Trainees'>Trainees</Link>
                <Link to='/Trainers'>Trainers</Link>
                </div>
            </nav>
        </div>
    )
}

export default Navbar