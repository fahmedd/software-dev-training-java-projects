import {useNavigate} from 'react-router-dom'
import '../styles/TraineeComponent.css'

const TraineeComponent= (props) => {

    const {name, stream, academy, id} = props.trainee

     const navigate = useNavigate()

    return(
        <div className="card">
            <div className="card-body">
            <h5 className="card-title"> Name: {name} </h5><br/>
            <h6 className="card-subtitle mb-2 text-muted">Stream: {stream.name}</h6>
            <p className="card-text"> Academy: {academy.name}</p>
            <button type="button" className="btn btn-secondary" onClick={() => {navigate('/ExamResultsPage/' + id)}}>View Exam Results</button>
            </div>
        </div>
                
    )
}

export default TraineeComponent