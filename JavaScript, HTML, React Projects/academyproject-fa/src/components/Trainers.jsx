import {useState, useEffect} from 'react'
import TrainerComponent from './TrainerComponent'
import axios from 'axios'
import '../styles/TrainerComponent.css'

const Trainers =() =>{

    const [trainers, setTrainers] = useState([])
    const api = 'http://localhost:8088/api/v1/trainer'

    const loadTrainers = () => {
        axios.get(api)
                .then(response => 
                    
                    setTrainers(response.data)
                    
                    )
                .catch(error => console.log('error retrieving list of Trainers'))
    }

    useEffect(() => {
       loadTrainers()
    },[])

    console.log(trainers)

    return(
         <div>

         <h1 className='trainerH1'>All Trainers:</h1>
         <div className='TrainerCards'>
        {
          trainers.map(trainer => <TrainerComponent key={trainer.id} trainer={trainer}/>)

        } 
        </div>

    </div>

    )

}

export default Trainers