import '../styles/TraineeComponent.css'
import {useState, useEffect} from 'react'
import TraineeComponent from './TraineeComponent'
import axios from 'axios'

const Trainees =() =>{

    const [trainees, setTrainees] = useState([])
    const api = 'http://localhost:8088/api/v1/trainee'

    const loadTrainees = () => {
        axios.get(api)
                .then(response => 
                    
                    setTrainees(response.data)
                    
                    )
                .catch(error => console.log('error retrieving list of trainees'))
    }

    useEffect(() => {
       loadTrainees()
    },[])

    return(
         <div>

        <h1 className='traineeH1'>All Traines:</h1>
         <div className='traineeCards'>
        {
          trainees.map(trainee => <TraineeComponent key={trainee.id} trainee={trainee}/>)

        } 
        </div>

    </div>

    )

}

export default Trainees