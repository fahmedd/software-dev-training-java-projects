import {useState, useEffect} from 'react'
import AcademyComponent from './AcademyComponent'
import '../styles/AcademyComponent.css'
import axios from 'axios'
import {Link} from 'react-router-dom'

const Academies =() =>{

    const [academies, setAcademies] = useState([])
    const api = 'http://localhost:8088/api/v1/academy/'


const loadAcademies = () => {
    axios.get(api)
            .then(response => 
                
                setAcademies(response.data)
                
                )
            .catch(error => console.log('error retrieving list of academies'))
}

    useEffect(() => {
        loadAcademies()
    },[])

    return(
        <div>

        <h1 className='academyH1'>All Academies:</h1>
        <div className='AcademyCards'>
        {
        academies.map(academies => <AcademyComponent key={academies.id} academies={academies}/>)

        } 
        </div>
        
        <div className='linkToAdd'>
        <button type="button" className="btn btn-dark"><Link to='/AddAcademy' className="link">Add A New Academy </Link></button>
        </div>
    </div>

    )


}

export default Academies