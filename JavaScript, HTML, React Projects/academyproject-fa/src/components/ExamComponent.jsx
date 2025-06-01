import '../styles/TraineeComponent.css'

const ExamComponent= (props) => {

    const {trainee, score, course} = props.examResult

    return(
        <div>
            <div className="card">
                <div className="card-body">
                <h5 className="card-title"> Trainee: {trainee.name} </h5><br/>
                <h6 className="card-text"> Course: {course.name}</h6><br/>
                <p className="card-text"> Score: {score}</p>
                </div>
            </div>
        </div>
                
    )
}

export default ExamComponent