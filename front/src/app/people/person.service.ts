import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Person} from './Person';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor(private http: HttpClient) {
  }

  getAll() {
    return this.http.get<Person>('http://localhost:8080/people');
  }
}
