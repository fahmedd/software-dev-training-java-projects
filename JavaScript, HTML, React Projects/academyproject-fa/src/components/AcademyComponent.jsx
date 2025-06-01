const AcademyComponent= (props) => {

    const {name, address} = props.academies

    return(
        <div className="card">
        <div className="academyCard-body">
        <h5 className="card-title"> Location: {name} </h5><br/>
        <p className="card-text"> Address: {address}</p>
        </div>

        <button type="button" className="btn btn-secondary">Select</button>
        </div>
            
        
         
    )
}

export default AcademyComponent