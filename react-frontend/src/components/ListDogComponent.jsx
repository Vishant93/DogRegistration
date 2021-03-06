import React, { Component } from 'react'
import DogService from '../services/DogService'

class ListDogComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dogs: []
        }
    }

    componentDidMount() {
        DogService.getDogs().then((res) => {
            this.setState({dogs: res.data});
        });
    }
    render() {
        return (
            <div>
                 <h2 className="text-center">Dog Registry</h2>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Dog Name</th>
                                    <th> Dog Age</th>
                                    <th> Dog Breed</th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.dogs.map(
                                        dog => 
                                        <tr key = {dog.id}>
                                             <td> {dog.dogName} </td>   
                                             <td> {dog.dogAge}</td>
                                             <td> {dog.dogBreed}</td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListDogComponent